window.onload = function() {
	const tableRows = document.getElementsByClassName("click")
	for (tableRow of tableRows) {
		const id = tableRow.children[0].textContent
		let newevent = function() {
			document.location.href = "/detail?id=" + id;
		};

		tableRow.addEventListener("click", newevent)
	}
}