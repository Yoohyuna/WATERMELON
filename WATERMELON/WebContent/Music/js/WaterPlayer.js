var audio = new Audio();
function player(dir) {
	$(function() {
		audio.src = dir;
		setInterval(function() {
			$('.currentTime').val(audio.currentTime);
		}, 1000)
	})
}
function waterPlay() {
	audio.play();
}

function waterPause() {
	audio.pause();
}

// function Player(dir) {
// var alertSound = new Audio(dir); // 오디오
// // 객체
// // 생성
// $(".sound_play").click(function(event) {
// if ($(".sound_play").text() == "재생") {
// $(".sound_play").text("정지");
// console.log(alertSound.played.length) // 현재 play 체크
// alertSound.play();
// alertSound.loop = true; // 반복여부
// return false;
// } else {
// $(".sound_play").text("재생");
// console.log(alertSound.paused) // 현재 paused 체크
// alertSound.pause();
// alertSound.currentTime = 0; // 재생을 처음으로 이동
// return false;
// }
// });
// $(".sound_pause").click(function(event) {
// console.log(alertSound.paused) // 현재 paused 체크
// alertSound.pause();
// alertSound.currentTime = 0; // 재생을 처음으로 이동
// return false;
// });
// $(".sound_volume_on").click(function(event) {
// alertSound.muted = true; // 소리끄기
// return false;
// });
// $(".sound_volume_off").click(function(event) {
// alertSound.muted = false; // 소리켜기
// return false;
// });
// }
