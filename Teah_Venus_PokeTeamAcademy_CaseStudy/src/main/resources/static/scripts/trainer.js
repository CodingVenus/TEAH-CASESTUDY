

function validateForm() {


    let namebox = document.forms["login-form"]["name"].value;
    let citybox = document.forms["login-form"]["towns"].value;

    let validation = true;

    if (citybox == "") {
        alert("Town must be selected.");

    }

    if (namebox == "") {
        alert("Name must be filled out.");

    }


}


