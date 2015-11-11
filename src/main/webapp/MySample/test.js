


//
//test = {
//    sprop : 'Hello',
//    oprop : {
//        u1 : 'Peter',
//        u2 : 'Vova'
//    },
//
//    f_great : function(user) {
//        console.log(this.sprop + ' ' + this.oprop[user]);
//    }
//}

//test.f_great('u1');


f_constr = function(arg1) {

    this.name = arg1;

    this.show_name = function() { console.log(this.name) }

};


obj1 = new f_constr('Cocoa');

obj1.show_name();

console.log(typeof f_constr.prototype);

console.log(typeof f_constr.prototype.constructor);

console.log( f_constr.prototype.constructor === f_constr );











