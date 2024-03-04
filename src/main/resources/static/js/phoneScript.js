



current_progress = document.querySelector("#risk-value");

console.log(current_progress.textContent);

document.getElementsByClassName("progress-bar")[0].style.width = current_progress.textContent+"%";