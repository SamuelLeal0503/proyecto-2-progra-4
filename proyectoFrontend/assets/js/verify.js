/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
    function checkPass() {
        var pass1 = document.getElementById("contra").value;
        var pass2 = document.getElementById("contracheck").value;
        if (pass1 != pass2) {
            alert("Las contraseñas no coinciden!");
            document.getElementById("contra").style.borderColor = "#E34234";
            document.getElementById("contracheck").style.borderColor = "#E34234";
        }
        else {
            document.getElementById("registro").submit();
        }
    }

    function mostrarDivPac() {
        var x = document.getElementById("formulario");
        if (x.style.display === "none") {
          x.style.display = "block";
        } else {
          x.style.display = "none";
        }
      }