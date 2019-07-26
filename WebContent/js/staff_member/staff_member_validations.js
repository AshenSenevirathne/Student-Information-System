/**
 * 
 */

function validations_StaffMember() {

	var name = document.forms["addStudents"]["name"];

	if (name.value == "") {
		window.alert("Plese Enter Name of Student");
		name.focus();
		return false;
	}

	var year = document.forms["addStudents"]["year"];

	if (year.value > 13 || year.value < 1) {
		window.alert("Plese Enter Year Between 1 and 13");
		year.focus();
		return false;
	}
		
}

function subject_validation() {
	
	var subCode = document.forms["addSubjects"]["subCode"];

	if (subCode.value == "") {
		window.alert("Plese Enter Name of Subject code");
		subCode.focus();
		return false;
	}
	
	var subName = document.forms["addSubjects"]["name"];
	if (subName.value == "") {
		window.alert("Plese Enter Name of Subject Name");
		subName.focus();
		return false;
	}
	
	var yearsub = document.forms["addSubjects"]["year"];

	if (yearsub.value > 13 || yearsub.value < 1) {
		window.alert("Plese Enter Year Between 1 and 13");
		yearsub.focus();
		return false;
	}
		
}

function timeTable_validations() {

	var examName = document.forms["addtimetables"]["examName"];

	if (examName.value == "") {
		window.alert("Plese Enter Timetable Name");
		examName.focus();
		return false;
	}

	var year = document.forms["addtimetables"]["year"];

	if (year.value > 13 || year.value < 1) {
		window.alert("Plese Enter Year Between 1 and 13");
		year.focus();
		return false;
	}
		
}