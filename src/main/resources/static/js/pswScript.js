function copyText() {
  console.log("ciao");
  var copyText = document.getElementById("textToCopy");
  copyText.select();
  copyText.setSelectionRange(0, 99999); 
  navigator.clipboard.writeText(copyText.value);

  alert("Testo copiato: " + copyText.value);
}


function updateTextInput(val) {
  console.log('in funzione js');
  console.log(val);
  document.getElementById('length').value=val;
  document.getElementById('range').value = val;
}
function increment(value){
  var input = document.getElementById("range")
  console.log('in funzione js');
  console.log(input.value);

  let currentValue = input.value
  input.value = +currentValue + value ;
  console.log('valore aggiornato');
  console.log(input.value);

  document.getElementById('range').value = input.value;
  document.getElementById('length').value = input.value;
}
/*
$(document).ready(function(){
  $('.count').prop('disabled', true);
   $(document).on('click','.plus',function(){
  $('.count').val(parseInt($('.count').val()) + 1 );
  });
    $(document).on('click','.minus',function(){
    $('.count').val(parseInt($('.count').val()) - 1 );
      if ($('.count').val() == 0) {
      $('.count').val(1);
    }
      });
});


// Validation submit
/*
var generatePswForm = document.getElementById("pwdGen");

generatePswForm.addEventListener("submit", (e) => {
  e.preventDefault();

  let length = document.getElementById("length");
  let isNumbers = document.getElementById("isNumbers");
  let isSymbols = document.getElementById("isSymbols");

  console.log(
  `This form has a length of ${length.value} and isNumbers of ${isNumbers.value} and isSymbols of ${isSymbols.value}`
    );

    length.value = "";
    isNumbers.value = "";
    isSymbols.value = "";
function range() {
  var x = document.getElementById("range").value;
  document.getElementById("length").innerHTML = x;
}

});
*/
