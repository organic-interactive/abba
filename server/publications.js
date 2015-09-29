Meteor.publish("getPosts", function () {
	return Posts.find({});
});