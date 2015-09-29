if (Meteor.isClient) {
  Meteor.subscribe("getPosts");

  Template.abba.helpers({
    getPosts: function() {
      return Posts.find();
    }
  });

  Template.abba.events({
    
  });
}
