package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Entity.User;
import Entity.User.Builder;
import Service.UserService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
 
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
 
		// Parse the request
		try {
			StringBuffer msg = new StringBuffer();
			User user=new User();
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				//如果是普通的form元素
				if(item.isFormField()) {
					String filename=item.getFieldName();
					String value=item.getString("utf-8");
					//System.out.println("普通form元素"+filename+":"+value);
					if(filename.equals("userName")) {
						user.setuName(value);
					}else if(filename.equals("userphonenumber")) {
						user.setuPhoneNumber(value);
					}else if(filename.equals("userPassword")) {
						user.setuPassword(value);
					}else if(filename.equals("userLocation")) {
						user.setuLocation(value);
					}else if(filename.equals("userDescription")) {
						user.setuDescription(value);
					}else if(filename.equals("Gender")) {
						Boolean Gender=Util.Validator.getGender(value);
						user.setuGender(Gender);
					}else if(filename.equals("userEmail")) {
						user.setuEmail(value);
					}else if(filename.equals("userType")) {
						user.setuType(value);
					}else if(filename.equals("userBirthday")) {
						try {
							Date userBirth=Util.Timeconverter.convertStringToDate(value);
							user.setuBirthday(userBirth);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					String filename=item.getName();
					System.out.println(filename);
					if(filename!=null){
						String defulat = "index.jpg";
						user.setuIcon(defulat);
					}else {
					String suffix=filename.substring(filename.lastIndexOf('.'));
					//为了防止上传到服务器中的文件重名，所以在上传的时候我们可以将文件进行自动生成前缀，只保留后缀，再拼接到一块的方法，来避免文件重名
					UUID uuid=UUID.randomUUID();
					String prefix=uuid.toString();
					//拼接后的文件名
					String savefilename=prefix+suffix;
					savefilename=savefilename.replace("-", "");
					//System.out.println("要保存的文件名为"+savefilename);
					String path=("C:\\Users\\dongtianhang\\Desktop\\e-workspace\\HR\\WebContent\\image");
					user.setuIcon(savefilename);
					InputStream is=item.getInputStream();
					OutputStream os=new FileOutputStream(new File(path+File.separator+savefilename));
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
			Integer age =0;
			 try {
		            age = Util.Timeconverter.getAge(user.getuBirthday()); 
		            user.setuAge(age);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			if(user.getuName()==null||user.getuPhoneNumber()==null||user.getuBirthday()==null||user.getuEmail()==null||user.getuPassword()==null||user.getuDescription()==null||user.getuLocation()==null||user.getuAge()==null) {
				msg.append("The required information is incomplete");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}
			if(user.getuName().length()<8||user.getuName().length()>16) {
				msg.append("User name with illegal length");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}	
			if(!Util.Validator.isNumber(user.getuPhoneNumber())) {
				msg.append("phoneNumber must be a number");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}
			if(!user.getuEmail().matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"))
			{
				msg.append("Illegal email format");
				request.setAttribute("msg", msg.toString());
				doGet(request, response);
				return;
			}
			UserService service =new UserService();
			Boolean result=service.insertUser(user);
			if(result==true) {
				msg.append("You have successfully created an account");
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