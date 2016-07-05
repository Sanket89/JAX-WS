package com.mkyong.test;


import java.io.File;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.mkyong.ArithmaticResponse;
import com.mkyong.Student;
import com.mkyong.Track;

@Path("/re")
public class RESTService {

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
	@Path("/getuserjson")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Student getUsers1( @DefaultValue("Vijay") @QueryParam("firstname") String firstName,
			@DefaultValue("Bhasker") @QueryParam("lastname") String lastName,
			@DefaultValue("HYD , SEC") @QueryParam("address") List<String> address) {
		
		//RestResponse response =new RestResponse();
		
		Student student =new Student();
		
		student.setAddress(address);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		 return student;

	}
	
	
	/*@GET
	@Path("/getuserjson")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getUsers(@QueryParam("format") String format , @DefaultValue("Vijay") @QueryParam("firstname") String firstName,
			@DefaultValue("Bhasker") @QueryParam("lastname") String lastName,
			@DefaultValue("HYD , SEC") @QueryParam("address") List<String> address) {
		
		//RestResponse response =new RestResponse();
		
		Student student =new Student();
		
		student.setAddress(address);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
	//	response.setStudent(student);
		
		 return Response
		            // Set the status and Put your entity here.
		            .ok(student)
		            // Add the Content-Type header to tell Jersey which format it should marshall the entity into.
		            .header(HttpHeaders.CONTENT_TYPE, "json".equals("json") ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
		            .build();

	}*/
	
	
	/*@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response service(@QueryParam("format") String format) {
	    return Response
	            // Set the status, entity and media type of the response.
	            .ok(entity, "json".equals(format) ? MediaType.APPLICATION_JSON : MediaType.APPLICATION_XML)
	            .build();
	}
	*/
	
	
	
	
	
	@GET
	@Path("/sum")
	@Produces(MediaType.APPLICATION_JSON)
	public ArithmaticResponse sum( @QueryParam("a") int a,
			 @QueryParam("b")  int b) {
		ArithmaticResponse arithmaticResponse =new ArithmaticResponse();
		arithmaticResponse.setArithmaticRes(a+b);
		return arithmaticResponse;

	}
	
	@GET
	@Path("/sumxml")
	@Produces(MediaType.APPLICATION_XML)
	public ArithmaticResponse sumXml( @QueryParam("a") int a,
			 @QueryParam("b")  int b) {
		ArithmaticResponse arithmaticResponse =new ArithmaticResponse();
		arithmaticResponse.setArithmaticRes(a+b);
		return arithmaticResponse;

	}
	
	
	
	
	
	@GET
	@Path("/getuserxml")
	@Produces(MediaType.APPLICATION_XML)
	public Student getUserXML(@DefaultValue("Vijay") @QueryParam("firstname") String firstName,
			@DefaultValue("Bhasker")@QueryParam("lastname") String lastName,
			@DefaultValue("HYD , SEC") @QueryParam("address") List<String> address) {
		
		
		Student student =new Student();
		student.setAddress(address);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		return student;

	}
	
	
	private static final String FILE_PATH = "C:\\Users\\Admin\\Desktop\\M.java";

	@GET
	@Path("/download")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"error1.html\"");
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