let circularProgress = document.querySelector(".circular-progress"),
    progressValue = document.querySelector(".progress-value");

console.log(media);

media = media * 10;

media = parseInt(media, 10);

let progressStartValue = -1,
    progressEndValue = media,
    speed = 30;

console.log(progressEndValue);

let progress = setInterval(function () {
    if (progressStartValue === progressEndValue) {
        clearInterval(progress);
    }

    progressValue.textContent = `${progressStartValue}%`

    progressStartValue++;

    if (progressStartValue < 33) {
        colorToChange = "green";
        progressValue.style.color = "green";
    } else if (progressStartValue >= 33 && progressStartValue < 66) {
        colorToChange = "yellow";
        progressValue.style.color = "yellow";
    } else {
        colorToChange = "red";
        progressValue.style.color = "red";
    }

    circularProgress.style.background = `conic-gradient(${colorToChange} ${progressStartValue * 3.6}deg, #ededed 0deg)`
}, speed);


