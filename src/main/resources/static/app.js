// these functions are for the button
let controls = new BlackJackGame();

function startblackjack() {
	controls.startblackjack();
}

function getLeaderBoardData(){
    new WinnerService().getAllWinners();
}

function hit() {
	controls.hit();
}

function stay() {
	controls.stay();
}