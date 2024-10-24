var REGEX_PHONE = /^(?:\(\d{2}\))?0[9]0\d{7}$|^(?:\(\d{2}\))?0[9]1\d{7}$/;
var REGEX_EMAIL = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
var REGEX_MaKH = /^KH\d{5}$/;
var REGEX_MaDV = /^DV\d{3}$/;

function validateKH(event) {
  event.preventDefault();
  let check = true;

  let phoneVal = $("#id-Phone").val();
  let emailVal = $("#id-Email").val();
  let maKHVal = $("#id-MaKH").val();

  if (!REGEX_PHONE.test(phoneVal)) {
    $("#id-phone-error").text("Không đúng định dạng Phone 090[1]xxxxxxx");
    check = false;
  } else {
    $("#id-phone-error").text("");
  }

  if (!REGEX_EMAIL.test(emailVal)) {
    $("#id-email-error").text("Không đúng định dạng email");
    check = false;
  } else {
    $("#id-email-error").text("");
  }

  if (!REGEX_MaKH.test(maKHVal)) {
    $("#id-maKH-error").text("Không đúng định dạng KHxxxxx");
    check = false;
  } else {
    $("#id-maKH-error").text("");
  }

  if (check) {
    document.getElementById("id-submit").dispatchEvent(new MouseEvent("click"));
  }
}

function validateDV(event) {
  event.preventDefault();
  let check = true;

  let idVal = $("#id-MaDV").val();

  if (!REGEX_MaDV.test(idVal)) {
    $("#id-maDV-error").text("Không đúng định dạng DVxxx");
    check = false;
  } else {
    $("#id-maDV-error").text("");
  }

  if (check) {
    document.getElementById("id-submit").dispatchEvent(new MouseEvent("click"));
  }
}
