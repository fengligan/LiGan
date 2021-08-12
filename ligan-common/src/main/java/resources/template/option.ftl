{
title:{
text: ${text},
x:'center',
y: 'top',
},
xAxis: {
name:${xName},
nameLocation:'middle',
nameTextStyle:{
marginTop:'20px'
},
type: 'value',
min:0,
max:100
},
yAxis: {
name:${yName},
scale: true,
nameLocation:'middle',
splitNumber : 5,
boundaryGap : [ 0.2, 0.2 ],
type: 'value',
min:0,
max:100
},
series: [{
barWidth : 10,
itemStyle: {
normal: {
　　color: '#000'
}
},
data: ${aoxList}
,
type: 'bar'
}]
}
