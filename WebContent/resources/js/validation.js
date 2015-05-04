function validate()
{
   if( document.result.date.value == "" )
   {
	     alert( "Please select date!" );
	     document.result.date.focus();
	     return false;
   }
   
   var date1 = $('#datepicker').datepicker('getDate') ;
   var  day1  = date1.getDate(); 
   var 	month1 = date1.getMonth() + 1;              
   var	year1 =  date1.getFullYear();
   
   var date2 = new Date();
   var  day2  = date2.getDate(); 
   var 	month2 = date2.getMonth() + 1;              
   var	year2 =  date2.getFullYear();
   
   if( year1 < year2 || ((year1 == year2)&&(month1<month2)) ||  (((year1 == year2) && (month1==month2) && day1 < day2)))
   {
	     alert( "Please select today's date or a future date!" );
	     document.result.date.focus();
	     return false;
   }
   
   if( document.result.time.value == "" )
   {
		 alert( "Please select time!" );
		 document.result.time.focus();
		 return false;
   }
   
   if( document.result.fromCity.value == document.result.toCity.value ){
	   	alert( "From city should be different than To city!" );
	    document.result.toCity.focus();
	    return false;
   }
   return true;
}

function logincheck()
{
   if( document.login.j_username.value == "" )
   {
	     alert( "Please enter username!" );
	     document.login.j_username.focus();
	     return false;
   }
   
   if( document.login.j_password.value == "" )
   {
	     alert( "Please enter password!" );
	     document.login.j_password.focus();
	     return false;
   }
   return true;
}

function validatebooking(){
	var ck_password =  /^[A-Za-z0-9-]/;
    if(!ck_password.test(document.confirm.passengerName.value))
    {
        alert("Name should be alphanumeric characters!");
        return false;
    }
    if(document.confirm.passengerAge.value== "" || isNaN(document.confirm.passengerAge.value) || document.confirm.passengerAge.value < 0 || document.confirm.passengerAge.value > 100){
    	 alert("Age should be numeric value  between 1 to 99");
    	 return false;
    }
    return true;
}


function ConfirmDelete()
{
	  alert("N");
  var x = confirm("Are you sure you want to cancel this booking?");
  if (x)
      return true;
  else
    return false;
}
