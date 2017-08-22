<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${ctx}/assets/admin/pages/scripts/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/assets/admin/pages/scripts/jquery.validate.methods.js"></script>
<script>
$(document).ready(
		function() {
			jQuery.validator.setDefaults({ 
			 //   debug: true,
			// 	errorElement: "div",
			    event: 'blur',
			    onkeyup : false,
			    errorPlacement: function(error, element) {
			    	var errorHint=element.siblings(".alert-danger");
			    	
			    	if(errorHint.length<1)
			    		errorHint = element.parent().next().children("span");
			    	if(errorHint.length<1)
			    		errorHint = element.parent().siblings(".alert-danger");
			    	
			    	
			    	if(error.text()!=''){
			    		errorHint.text(error.text());
			    	}else{
			    		errorHint.text("");
			    	}
//			   		if (element.is(':radio') || element.is(':checkbox')) {
//			         	error.appendTo(element.parent());
//			      	} else {
//			          	error.insertAfter(element);
//			     	}
			    },
			    success: function(label) {
	//		    	label.text("").addClass("success");
				}
			});
		}
);
</script>