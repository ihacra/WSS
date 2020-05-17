<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<style>
.wrapper {
	background: #f8c3cd;
	opacity: 0.6;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	overflow: hidden;
	z-index: -1000;
}

.bg-bubbles li {
	position: absolute;
	list-style: none;
	display: block;
	width: 50px;
	height: 50px;
	background-color: rgba(255, 255, 255, 0.2);
	bottom: -150px;
	-webkit-animation: square 25s infinite;
	animation: square 20s infinite;
	-webkit-transition-timing-function: linear;
	transition-timing-function: linear;
}

.bg-bubbles li:nth-child(1) {
	left: 3%;
	background-color: rgba(255, 255, 255, 0.25);
}

.bg-bubbles li:nth-child(2) {
	left: 10%;
	width: 80px;
	height: 80px;
	-webkit-animation-delay: 2s;
	animation-delay: 2s;
	-webkit-animation-duration: 12s;
	animation-duration: 12s;
}

.bg-bubbles li:nth-child(3) {
	left: 20%;
	-webkit-animation-delay: 4s;
	animation-delay: 4s;
}

.bg-bubbles li:nth-child(4) {
	left: 30%;
	width: 60px;
	height: 60px;
	-webkit-animation-duration: 18s;
	animation-duration: 18s;
	background-color: rgba(255, 255, 255, 0.25);
}

.bg-bubbles li:nth-child(5) {
	left: 40%;
}

.bg-bubbles li:nth-child(6) {
	left: 50%;
	width: 90px;
	height: 90px;
	-webkit-animation-delay: 3s;
	animation-delay: 3s;
	background-color: rgba(255, 255, 255, 0.2);
}

.bg-bubbles li:nth-child(7) {
	left: 60%;
	width: 80px;
	height: 80px;
	-webkit-animation-delay: 7s;
	animation-delay: 7s;
}

.bg-bubbles li:nth-child(8) {
	left: 70%;
	width: 40px;
	height: 40px;
	-webkit-animation-delay: 8s;
	animation-delay: 8s;
	-webkit-animation-duration: 15s;
	animation-duration: 15s;
}

.bg-bubbles li:nth-child(9) {
	left: 80%;
	width: 50px;
	height: 50px;
	-webkit-animation-delay: 2s;
	animation-delay: 2s;
	-webkit-animation-duration: 20s;
	animation-duration: 20s;
	background-color: rgba(255, 255, 255, 0.25);
}

.bg-bubbles li:nth-child(10) {
	left: 90%;
	width: 70px;
	height: 70px;
	-webkit-animation-delay: 6s;
	animation-delay: 6s;
	background-color: rgba(255, 255, 255, 0.3);
}

@-webkit-keyframes square {
  0% {
    -webkit-transform: translateY(-150px);
            transform: translateY(-150px);
  }
  100% {
    -webkit-transform: translateY(-800px) rotate(600deg);
            transform: translateY(-800px) rotate(600deg);
  }
}

@keyframes square {
  0% {
    -webkit-transform: translateY(-150px);
            transform: translateY(-150px);
  }
  100% {
    -webkit-transform: translateY(-800px) rotate(600deg);
            transform: translateY(-800px) rotate(600deg);
  }
}
</style>

<div class="wrapper">
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
