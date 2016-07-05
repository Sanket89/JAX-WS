<!DOCTYPE html>
<html>
<h1>Rest example </h1>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type = "text/javascript" language = "javascript">

$(document).ready(function() { 
	/* restCall(); */
 });



function restCall(){
	
  $.ajax({
           type: "GET", 
           url: "/RESTfulExample/rest/user/getuserjson", 
           dataType: 'json', 
           data : { firstname : 'Vijay' , lastname : 'Bhasker' },
           cache: false, 
           success: function(data) {
        	 //  $('#restRes').html(data.firstName +" " +data.lastName);
        	 var firstPart='<table style="width:100%"> <tr>  <th>First Name</td>    <th>Last Name</td>  </tr>';  
        	 
        	  		var data='<tr><td>'+data.firstName +'</td>  <td>'+data.lastName+'</td>  </tr>';
           			
           			var tableClose='</table>';
           			
           			$('#restRes').html(firstPart + data +tableClose);
        	   
        	   
           },
         error: function (xhr, ajaxOptions, thrownError) {
        	
        	 }
       });
}  
     
 </script>

<a href="#" id="jsonload" onclick="restCall()">Make Request</a> 
<span id="restRes"></span>
</html>