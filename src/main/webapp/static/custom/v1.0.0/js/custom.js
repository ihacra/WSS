// 表单验证
function verification(form) {
	form.addEventListener('submit', function(event) {
		if (form.checkValidity() === false) {
		    event.preventDefault();
		    event.stopPropagation();
		}
		form.classList.add('was-validated');
    }, false);
}
