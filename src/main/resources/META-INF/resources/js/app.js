$(function(){
    var ctx = document.getElementById("myChart").getContext("2d");
    var labels = new Array();
    $("p span.timestamp").each(function(){
        labels.push($(this).text())
    });
    var counts = new Array();
    $("p span.count").each(function(){
        counts.push(new Number($(this).text()))
    });
    var data = {
        labels: labels,
        datasets: [
            {
                label: "Фотки с Белухи",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: counts
            }
        ]
    };
    var myNewChart = new Chart(ctx).Line(data);
});