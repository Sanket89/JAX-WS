package com.mkyong.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.mkyong.Student;
import com.mkyong.Track;
import com.sun.jersey.core.header.FormDataContentDisposition;

@Path("/user")
public class JSONService {

	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getTrackInJSON() {
		Student student =new Student();
		student.setFirstName("JSON_Firstname");
		student.setLastName("JSON_Lastname");
		return student;
	}

	
	
	@GET
	@Path("{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student pathParam(@PathParam("studentId") int sid) {
		Student student =new Student();
		student.setId(sid);
		student.setFirstName("JSON_Firstname");
		student.setLastName("JSON_Lastname");
		return student;
	}

	
	
	
	
	@GET
	@Path("/getuserjson")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getUsers(@DefaultValue("Vijay") @QueryParam("firstname") String firstName,
			@DefaultValue("Bhasker") @QueryParam("lastname") String lastName,
			@DefaultValue("HYD , SEC") @QueryParam("address") List<String> address) {
		
		//RestResponse response =new RestResponse();
		
		Student student =new Student();
		
		student.setAddress(address);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
	//	response.setStudent(student);
		return student;

	}
	
	@GET
	@Path("/getuserxml/{userId}")
	@Produces(MediaType.APPLICATION_XML)
	public Student getUserXML(@PathParam("userId") int userId ,@DefaultValue("Vijay") @QueryParam("firstname") String firstName,
			@DefaultValue("Bhasker")@QueryParam("lastname") String lastName,
			@DefaultValue("HYD , SEC") @QueryParam("address") List<String> address) {
		
		
		Student student =new Student();
		student.setAddress(address);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		return student;

	}
	
	
	private static final String FILE_PATH = "C:\\Users\\Admin\\Desktop\\sai baba pic 2.jpeg";

	@GET
	@Path("/download")
	@Produces("text/plain")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=\"sai baba pic 2.jpeg\"");
		return response.build();

	}

	
	
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month, 
			@PathParam("day") int day) {

	   String date = year + "/" + month + "/" + day;
	   return Response.status(200).entity("getUserHistory is called, year/month/day : " + date).build();

	}
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
	
/*	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
		@FormDataParam("resume") InputStream uploadedInputStream,
		@FormDataParam("resume") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

		// save it
		writeToFile(uploadedInputStream, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;

		return Response.status(200).entity(output).build();

	}
	// save uploaded file to new location
		private void writeToFile(InputStream uploadedInputStream,
			String uploadedFileLocation) {

			try {
				OutputStream out = new FileOutputStream(new File(
						uploadedFileLocation));
				int read = 0;
				byte[] bytes = new byte[1024];

				out = new FileOutputStream(new File(uploadedFileLocation));
				while ((read = uploadedInputStream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	*/
	
}