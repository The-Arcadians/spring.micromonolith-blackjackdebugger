// the purpose of this class is to mediate the behaviors of `PlayerData` and `PlayerView`
class BlackJackPlayer {
   
    constructor(id, name, numberOfWins) {
        this.id = id;
        this.name = name;
        this.numberOfWins = numberOfWins;
        this.blackJackPlayerData = new BlackJackPlayerStateLogger(id, name, numberOfWins);
        this.blackJackPlayerView = new BlackJackPlayerView(this.blackJackPlayerData);
    }

    // prints the cards of the current BlackJackPlayerState
    viewHand() {
        this.blackJackPlayerView.viewHand();
    }

    // add card to hand
    hit(deck) {
        this.addCard(deck.removeAndFetchTopMostCard());
    }
    
    addCard(cardToAddToHand) {
        this.blackJackPlayerView.clearHand();    
        this.blackJackPlayerData.addCard(cardToAddToHand);
        this.blackJackPlayerView.renderHand();
    }

    getHandTotal() {
        return this.blackJackPlayerData.getHandTotal();
    }

    toString() {
        return this.blackJackPlayerData.toString();
    }
}