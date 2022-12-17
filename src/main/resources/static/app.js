// these functions are for the button
let controls = new BlackJackGame();

function startblackjack() {
	console.log(new WinnerService().readById(2));
	controls.startblackjack();
}

function hit() {
	controls.hit();
}

function stay() {
	controls.stay();
}