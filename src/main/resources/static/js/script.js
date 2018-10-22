function QueueHint() {
	var self = this;
	var hintId = "queueHint";
	
	self.showHint = function(queueName){
		if(queueName === 'AutoConsumeQueue') {
			document.getElementById(hintId).innerHTML = "you can see in console terminal";
		} else {
			document.getElementById(hintId).innerHTML = "";
		}
	};
}

var queueHint = new QueueHint();