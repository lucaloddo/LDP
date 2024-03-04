var maliciousLevel = parseInt(document.querySelector("#malicious-level").textContent);
var harmlessLevel = parseInt(document.querySelector("#harmless-level").textContent);

var xValues = ["Innocuo", "Dannoso"];
var yValues = [harmlessLevel, maliciousLevel];

var barColors = ["green", "red"];

new Chart("canvas", {
    type: "pie",
    data: {
        labels: xValues,
        datasets: [{
            backgroundColor: barColors,
            data: yValues
        }]
    },
    options: {
        title: {
            display: true
        }
    }
});

var harmlessStat = parseInt(document.querySelector("#harmless-stat").textContent);
var typeUnsupportedStat = parseInt(document.querySelector("#type-unsupported-stat").textContent);
var suspiciousStat = parseInt(document.querySelector("#suspicious-stat").textContent);
var confirmedTimeoutStat = parseInt(document.querySelector("#confirmed-timeout-stat").textContent);
var timeoutStat = parseInt(document.querySelector("#timeout-stat").textContent);
var failureStat = parseInt(document.querySelector("#failure-stat").textContent);
var maliciousStat = parseInt(document.querySelector("#malicious-stat").textContent);
var undetectedStat = parseInt(document.querySelector("#undetected-stat").textContent);

var xStatsValues = ["Innocuo", "Tipo non supportato", "Sospettoso", "Timeout confermato", "Timeout", "Difettoso", "Dannoso", "Non rilevabile"];

var yStatsValues = [
    harmlessStat,
    typeUnsupportedStat,
    suspiciousStat,
    confirmedTimeoutStat,
    timeoutStat,
    failureStat,
    maliciousStat,
    undetectedStat
];
console.log(yStatsValues[0]);
console.log(yStatsValues[1]);
console.log(yStatsValues[2]);
console.log(yStatsValues[3]);
console.log(yStatsValues[4]);
console.log(yStatsValues[5]);
console.log(yStatsValues[6]);
console.log(yStatsValues[7]);

var barStatsColors = ["#b91d47", "#00FF00", "#0000FF", "#FF00FF", "#800080", "#FFA500", "#00aba9", "#FFFF00"];

new Chart("canvasStats", {
    type: "bar",
    data: {
        labels: xStatsValues,
        datasets: [
        {
         label: xStatsValues[0],
         data: [yStatsValues[0],0,0,0,0,0,0,0],
         backgroundColor: barStatsColors[0],
         },
        {
         label: xStatsValues[1],
         data: [0,yStatsValues[1],0,0,0,0,0,0],
         backgroundColor: barStatsColors[1],
         },
        {
         label: xStatsValues[2],
         data: [0,0,yStatsValues[2],0,0,0,0,0],
         backgroundColor: barStatsColors[2],
        },
        {
         label: xStatsValues[3],
         data: [0,0,0,0,yStatsValues[3],0,0,0,0],
         backgroundColor: barStatsColors[3],
         },
        {
         label: xStatsValues[4],
         data: [0,0,0,0,yStatsValues[4],0,0,0],
         backgroundColor: barStatsColors[4],
         },
        {
         label: xStatsValues[5],
         data: [0,0,0,0,0,yStatsValues[5],0,0],
         backgroundColor: barStatsColors[5],
         },
        {
         label: xStatsValues[6],
         data: [0,0,0,0,0,0,yStatsValues[6],0],
         backgroundColor: barStatsColors[6],
         },
        {
         label: xStatsValues[7],
         data: [0,0,0,0,0,0,0,yStatsValues[7]],
         backgroundColor: barStatsColors[7],
         }
        ]
    },
    labels: xStatsValues,
    name: xStatsValues,
    legend: {
                display: true,
                legendText : xStatsValues
                    },
    options: {
        title: {
            display: true
        }
    }
});