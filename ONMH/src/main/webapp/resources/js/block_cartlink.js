/*
	path : 이동하는 경로
*/

$(function(){
	$('.block-link').css('cursor', 'pointer');
	$('.block-link').click(function(){
		const code = $(this).attr('data-ccode');
		location.href = path+'/'+code;
	});
});