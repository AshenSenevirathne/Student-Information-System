/**
 * 
 */

function classValidations()                                    
{ 
    var year = document.forms["RegForm"]["year"];               
    var className = document.forms["RegForm"]["className"];
    var noOFStudents = document.forms["RegForm"]["studentNo"];
    var teacherName = document.forms["RegForm"]["teacherName"];
    var hall = document.forms["RegForm"]["hall"];
    
    if (year.value > 13 || year.value < 1)                                  
    { 
        window.alert("Plese Enter Year Between 1 and 13"); 
        year.focus(); 
        return false; 
    } 
    
    if (className.value == "")                                  
    { 
        window.alert("Plese Enter Class Name"); 
        className.focus(); 
        return false; 
    } 
    
    if (noOFStudents.value > 50 || noOFStudents.value <= 0)                                  
    { 
        window.alert("Plese Enter Student Count between 1 to 50"); 
        noOFStudents.focus(); 
        return false; 
    } 
    
    if (teacherName.value == "")                                  
    { 
        window.alert("Plese Enter Teacher Name"); 
        teacherName.focus(); 
        return false; 
    } 
   
    if (hall.value == "")                                  
    { 
        window.alert("Plese Enter Hall Name"); 
        hall.focus(); 
        return false; 
    } 
   
    return true; 
}


function markValidations() {
	
var mark = document.forms["marks"]["subjectMark"];
    
    if (mark.value >= 0 || mark.value <= 100)                                  
    { 
        window.alert("Plese Enter Mark Between 0 and 100"); 
        mark.focus(); 
        return false; 
    } 
}







