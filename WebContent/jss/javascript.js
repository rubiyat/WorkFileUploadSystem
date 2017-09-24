function checkPass()
{

    var pass1 = document.getElementById('password');
    var pass2 = document.getElementById('conformPassword');
    //var message = document.getElementById('confirmMessage');
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    if(pass1.value == pass2.value){ 
        pass2.style.borderColor = goodColor;
        message.style.color = goodColor;
        
    }else{
        pass2.style.borderColor = badColor;
        message.style.color = badColor;
        
    }
   
}  

function myValidation(){
	$(document).on("click", ".form", function(e) {
	    bootbox.alert("Hello world!"); 

	});
}

