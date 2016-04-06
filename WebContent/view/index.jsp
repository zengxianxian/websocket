<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
<h1>Hello World!</h1>
<textarea rows="4" cols="10" id="recMsgTextArea"></textarea>
<hr>
<textarea rows="4" cols="10" id="sendMsgTextArea"></textarea>
<hr>
<button id="sendMsgBtn" >Send</button><button id="initBtn" >init</button>
</body>
<script type="text/javascript" src="./../StaticResources/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	
//	var WebSocket = window.WebSocket || window.MozWebSocket;
	var isConnected = false;
	var wSocket;
	$(function(){		
		$("#sendMsgBtn").click(function(){
			SendMsg();
		});
		$("#initBtn").click(function(){
//			initWebSocket("ws://"+window.location.host+"${pageContext.request.contextPath}/firstWS");
//			initWebSocket("ws://"+window.location.host+"${pageContext.request.contextPath}/firstWS");
			initWebSocket("ws://"+window.location.host+"/firstWS");
		});
	});
	
	function doOpen(){
		isConnected = true;
	}
	
	function doClose(){
		isConnected = false;
		showMsg("链接已经断开");
	}
	
	function doError(){
		isConnected = false;
		showMsg("链接异常");
	}
	
	function doMessage(message){
		showMsg(message);
	}
	
	function doSend(message){
		if(wSocket){
			wSocket.send(message);
		} else {
			showMsg("您已经掉线了");
		}
	}
	
	
	
	function initWebSocket(wcUrl){
		if(WebSocket) {
			wSocket = new WebSocket(encodeURI(wcUrl));
			wSocket.onopen = doOpen;
			wSocket.onerror = doError;
			wSocket.onclose = doClose;
			wSocket.onmessge = doMessage;
		} else {
			showMsg("您的设备不支持websocket");
		}
	}
	
	function showMsg(message){
		var v = $("#recMsgTextArea").val();
		if(v != ""){
			v = v + "\n"+message;
		}else{
			v = message;
		}
		$("#recMsgTextArea").val(message);
	}
	
	function SendMsg(){
		var message = $("#sendMsgTextArea").val();
		if(message != ""){
			doSend(message);
		}
		$("#sendMsgTextArea").val('');
	}
	
</script>
</html>