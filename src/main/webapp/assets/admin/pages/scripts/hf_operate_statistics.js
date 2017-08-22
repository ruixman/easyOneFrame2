var ChartsFlotcharts = function() {

    return {
        //main function to initiate the module

        init: function() {

            Metronic.addResizeHandler(function() {
                Charts.initPieCharts();
            });

        },

        initCharts: function() {

            if (!jQuery.plot) {
                return;
            }

            var data = [];
            var totalPoints = 250;

            // random data generator for plot charts

            function getRandomData() {
                if (data.length > 0) data = data.slice(1);
                // do a random walk
                while (data.length < totalPoints) {
                    var prev = data.length > 0 ? data[data.length - 1] : 50;
                    var y = prev + Math.random() * 10 - 5;
                    if (y < 0) y = 0;
                    if (y > 100) y = 100;
                    data.push(y);
                }
                // zip the generated y values with the x values
                var res = [];
                for (var i = 0; i < data.length; ++i) {
                    res.push([i, data[i]]);
                }

                return res;
            }

            //Basic Chart

            function chart2() {
                if ($('#chart_2').size() != 1) {
                    return;
                }

                function randValue() {
                    return (Math.floor(Math.random() * (1 + 40 - 20))) + 20;
                }
                var pageviews = [
                    [1, randValue()],
                    [2, randValue()],
                    [3, 2 + randValue()],
                    [4, 3 + randValue()],
                    [5, 5 + randValue()],
                    [6, 10 + randValue()],
                    [7, 15 + randValue()],
                    [8, 20 + randValue()],
                    [9, 25 + randValue()],
                    [10, 30 + randValue()],
                    [11, 35 + randValue()],
                    [12, 25 + randValue()],
                    [13, 15 + randValue()],
                    [14, 20 + randValue()],
                    [15, 45 + randValue()],
                    [16, 50 + randValue()],
                    [17, 65 + randValue()],
                    [18, 70 + randValue()],
                    [19, 85 + randValue()],
                    [20, 80 + randValue()],
                    [21, 75 + randValue()],
                    [22, 80 + randValue()],
                    [23, 75 + randValue()],
                    [24, 70 + randValue()]
                ];
                var visitors = [
                    [1, randValue() - 5],
                    [2, randValue() - 5],
                    [3, randValue() - 5],
                    [4, 6 + randValue()],
                    [5, 5 + randValue()],
                    [6, 20 + randValue()],
                    [7, 25 + randValue()],
                    [8, 36 + randValue()],
                    [9, 26 + randValue()],
                    [10, 38 + randValue()],
                    [11, 39 + randValue()],
                    [12, 50 + randValue()],
                    [13, 51 + randValue()],
                    [14, 12 + randValue()],
                    [15, 13 + randValue()],
                    [16, 14 + randValue()],
                    [17, 15 + randValue()],
                    [18, 15 + randValue()],
                    [19, 16 + randValue()],
                    [20, 17 + randValue()],
                    [21, 18 + randValue()],
                    [22, 19 + randValue()],
                    [23, 20 + randValue()],
                    [24, 21 + randValue()]
                ];
                var data4 = [
                    [1, randValue() - 5],
                    [2, randValue() - 5],
                    [3, randValue() - 5],
                    [4, 6 + randValue()],
                    [5, 5 + randValue()],
                    [6, 20 + randValue()],
                    [7, 25 + randValue()],
                    [8, 36 + randValue()],
                    [9, 26 + randValue()],
                    [10, 38 + randValue()],
                    [11, 39 + randValue()],
                    [12, 50 + randValue()],
                    [13, 51 + randValue()],
                    [14, 12 + randValue()],
                    [15, 13 + randValue()],
                    [16, 14 + randValue()+10],
                    [17, 15 + randValue()+10],
                    [18, 15 + randValue()+10],
                    [19, 16 + randValue()+10],
                    [20, 17 + randValue()+10],
                    [21, 18 + randValue()+10],
                    [22, 19 + randValue()+10],
                    [23, 20 + randValue()+10],
                    [24, 21 + randValue()+10]
                ];
                var data3 = [
                    [1, randValue() - 5],
                    [2, randValue() - 5],
                    [3, randValue() - 5],
                    [4, 6 + randValue()],
                    [5, 5 + randValue()],
                    [6, 20 + randValue()],
                    [7, 25 + randValue()],
                    [8, 36 + randValue()],
                    [9, 26 + randValue()],
                    [10, 38 + randValue()],
                    [11, 39 + randValue()],
                    [12, 50 + randValue()],
                    [13, 51 + randValue()],
                    [14, 12 + randValue()],
                    [15, 13 + randValue()],
                    [16, 14 + randValue()],
                    [17, 15 + randValue()],
                    [18, 15 + randValue()],
                    [19, 16 + randValue()],
                    [20, 17 + randValue()],
                    [21, 18 + randValue()],
                    [22, 19 + randValue()],
                    [23, 20 + randValue()],
                    [24, 21 + randValue()]
                ];
                var data5 = [
                    [1, randValue() - 10],
                    [2, randValue() - 10],
                    [3, randValue() - 10],
                    [4, 6 + randValue() - 10],
                    [5, 5 + randValue() - 10],
                    [6, 10 + randValue() - 10],
                    [7, 12 + randValue() - 10],
                    [8, 12 + randValue() - 10],
                    [9, 11 + randValue() - 10],
                    [10, 12 + randValue() - 10],
                    [11, 11 + randValue() - 10],
                    [12, 10 + randValue() - 10],
                    [13, 11 + randValue() - 10],
                    [14, 2 + randValue() - 10],
                    [15, 3 + randValue() - 10],
                    [16, 4 + randValue() - 10],
                    [17, 5 + randValue() - 10],
                    [18, 5 + randValue() - 10],
                    [19, 6 + randValue() - 10],
                    [20, 7 + randValue() - 10],
                    [21, 8 + randValue() - 10],
                    [22, 9 + randValue() - 10],
                    [23, 10 + randValue() - 10],
                    [24, 11 + randValue() - 10]
                ];
                var plot = $.plot($("#chart_2"), [{
                    data: pageviews,
                    label: "下载用户数",
                    lines: {
                        lineWidth: 1,
                    },
                    shadowSize: 0

                }, {
                    data: visitors,
                    label: "注册用户数",
                    lines: {
                        lineWidth: 1,
                    },
                    shadowSize: 0
                }, {
                    data: data3,
                    label: "充值用户数",
                    lines: {
                        lineWidth: 1,
                    },
                    shadowSize: 0
                }, {
                    data: data4,
                    label: "活跃用户数",
                    lines: {
                        lineWidth: 1,
                    },
                    shadowSize: 0
                }, {
                    data: data5,
                    label: "并发用户数",
                    lines: {
                        lineWidth: 1,
                    },
                    shadowSize: 0
                }], {
                    series: {
                        lines: {
                            show: true,
                            lineWidth: 2,
                            fill: true,
                            fillColor: {
                                colors: [{
                                    opacity: 0.05
                                }, {
                                    opacity: 0.01
                                }, {
                                    opacity: 0.01
                                }, {
                                    opacity: 0.01
                                }, {
                                    opacity: 0.01
                                }]
                            }
                        },
                        points: {
                            show: true,
                            radius: 3,
                            lineWidth: 1
                        },
                        shadowSize: 2
                    },
                    grid: {
                        hoverable: true,
                        clickable: true,
                        tickColor: "#eee",
                        borderColor: "#eee",
                        borderWidth: 1
                    },
                    // colors: ["#d12610", "#37b7f3", "#52e136",""],
                    xaxis: {
                        // ticks: 11,
                        tickDecimals: 0,
                        tickColor: "#eee",
                        ticks:[
                            [2,'02:00AM'],
                            [4,'04:00AM'],
                            [6,'06:00AM'],
                            [8,'08:00AM'],
                            [10,'10:00AM'],
                            [12,'12:00AM'],
                            [14,'14:00PM'],
                            [16,'16:00PM'],
                            [18,'18:00PM'],
                            [20,'20:00PM'],
                            [22,'22:00PM'],
                            [24,'24:00PM'],
                        ]
                    },
                    yaxis: {
                        ticks: 11,
                        tickDecimals: 0,
                        tickColor: "#eee",
                    }
                });


                function showTooltip(x, y, contents) {
                    $('<div id="tooltip">' + contents + '</div>').css({
                        position: 'absolute',
                        display: 'none',
                        top: y + 5,
                        left: x + 15,
                        border: '1px solid #333',
                        padding: '4px',
                        color: '#fff',
                        'border-radius': '3px',
                        'background-color': '#333',
                        opacity: 0.80
                    }).appendTo("body").fadeIn(200);
                }

                var previousPoint = null;
                $("#chart_2").bind("plothover", function(event, pos, item) {
                    $("#x").text(pos.x.toFixed(2));
                    $("#y").text(pos.y);

                    if (item) {
                        if (previousPoint != item.dataIndex) {
                            previousPoint = item.dataIndex;

                            $("#tooltip").remove();
                            var x = item.datapoint[0].toFixed(2),
                                y = item.datapoint[1];

                            showTooltip(item.pageX, item.pageY, item.series.label + " : " + y);
                        }
                    } else {
                        $("#tooltip").remove();
                        previousPoint = null;
                    }
                });
            }

            //graph
            chart2();

        }
    };

}();