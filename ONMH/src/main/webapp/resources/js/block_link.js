/*
	path : 이동하는 경로
*/

$(function(){
	$('.block-link').css('cursor', 'pointer');
	$('.block-link').click(function(){
		const code = $(this).attr('data-code');
		location.href = path+'/'+code;
	});
});
$(function(){
	$('.block-link2').css('cursor', 'pointer');
	$('.block-link2').click(function(){
		const code = $(this).attr('data-code');
		location.href = pa+'/'+code;
	});
});