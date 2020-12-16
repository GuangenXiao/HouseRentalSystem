package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Entity.House;
import Entity.User;
import Service.HouseService;
import Service.UserService;
import Util.Converter;
import Util.ConverterFactory;

/**
 * Servlet implementation class HouseServlet
 */
@WebServlet("/HouseServlet")
public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/house.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
 
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
 
		// Parse the request
		try {
			StringBuffer msg = new StringBuffer();
			House house=new House();
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				//如果是普通的form元素
				if(item.isFormField()) {
					String filename=item.getFieldName();
					String value=item.getString("utf-8");
					//System.out.println("普通form元素"+filename+":"+value);
					if(filename.equals("HouseType")) {
						house.sethType(Integer.parseInt(value));
					}else if(filename.equals("HouseEnergy")) {
						house.sethEnergy(value);
					}else if(filename.equals("HouseAddress")) {
						house.sethAddress(value);
					}else if(filename.equals("HouseParknumber")) {
						house.sethPark(Integer.parseInt(value));
					}else if(filename.equals("houseDescription")) {
						house.sethDescription(value);
					}else if(filename.equals("houseEquipment")) {
						house.sethEquipment(value);
					}else if(filename.equals("Housesize")) {
						house.sethSize(Integer.parseInt(value));
					}else if(filename.equals("HouseBirthday")) {
						try {
							ConverterFactory  cf = new ConverterFactory();
							Converter c = cf.getConverter("DATE");
							Date houseBirth=c.convertString(value);
							house.sethDate(houseBirth);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					String filename=item.getName();
					System.out.println(filename);
					if(filename.length()==0){
						String defulat = "index.jpg";
						house.sethPicture(defulat);
					}else {
					String suffix=filename.substring(filename.lastIndexOf('.'));
					//为了防止上传到服务器中的文件重名，所以在上传的时候我们可以将文件进行自动生成前缀，只保留后缀，再拼接到一块的方法，来避免文件重名
					UUID uuid=UUID.randomUUID();
					String prefix=uuid.toString();
					//拼接后的文件名
					String savefilename=prefix+suffix;
					savefilename=savefilename.replace("-", "");
					//System.out.println("要保存的文件名为"+savefilename);
					String webPath="/image/";
					String filepath=getServletContext().getRealPath(webPath);
					house.sethPicture(savefilename);
					InputStream is=item.getInputStream();
					OutputStream os=new FileOutputStream(new File(filepath+File.separator+savefilename));
					byte[] b=new byte[1024];
					int len;
					while((len=is.read(b))!=-1) {
						os.write(b, 0, len);
					}
					is.close();
					os.close();
				}
			  }
			}
			if(house.gethAddress()==null||house.gethDate()==null||house.gethDescription()==null||house.gethEnergy()==null||house.gethType()==null||house.gethEquipment()==null||house.gethPark()==null||house.gethSize()==null) {
				msg.append("The required information is incomplete!");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}
	        User user = (User)request.getSession().getAttribute("user");
	        Integer ID=user.getuId();
	        house.sethOwnerId(ID);
			HouseService service=new HouseService();
			Boolean result=service.insertHouse(house);
			if(result==true) {
				msg.append("You have successfully post a new house");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}
			else
			{
				msg.append("An error has occurred");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}
		}  catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}