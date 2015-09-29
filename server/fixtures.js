Meteor.startup(function() {

	var snarg = "asdf";
	var now = new Date();
	var picA = "picA.jpg";
	var picB = "picB.jpg";

	function randomVotes() {
		return Math.floor(Math.random() * (10 + 1));
	};
	// Reset the Posts collection and seed it with a couple of lifts
	Posts.remove({});

	for(var count = 0; count < 10; count++) {
		Posts.insert({
			userId: snarg,
			dateSubmitted: now,
			a : {
				path : picA,
				votes : randomVotes()
			},
			b : {
				path : picB,
				votes : randomVotes()
			}
		});
	}
});