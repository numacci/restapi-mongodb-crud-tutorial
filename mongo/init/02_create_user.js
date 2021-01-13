let user = {
  user: 'appuser',
  pwd: 'appuser',
  roles: [{
    role: 'readWrite',
    db: 'appdb'
  }]
};

db.createUser(user);