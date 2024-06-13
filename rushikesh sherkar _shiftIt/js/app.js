var gameLogic = new GameLogic();

function GameLogic(){
		this.startTimer=startTimer;
		this.startTimer.updateTimer=startTimer.updateTimer;
		this.stopTimer=stopTimer;
		this.updateElement=updateElement;
		this.createBoard=createBoard;
		this.updateCount=updateCount;
		this.restartCount=restartCount;
		this.play = play;
		this.swap=swap;
		this.addTile=addTile;
		this.isMovePossible=isMovePossible;
		this.move=move;
		this.shuffle=shuffle;
		this.checkWinCondition=checkWinCondition;

		var level;
		var max;
		var board;
		var count = 0;
		var i;

		var timer;

		var secondsEl = document.getElementById('seconds');
		var minutesEl = document.getElementById('minutes');
		var hoursEl = document.getElementById('hours');

		var start = document.getElementById('start');

		var menu = document.getElementById('menu');

		var completedLevel = document.getElementById('completedLevel');

		var next = document.getElementById('next');

		var counter = document.getElementById('count');

		var gameOver = document.getElementById('gameOver');

		var shuffleButton = document.getElementById('shuffle');

		
		// start the game
		start.addEventListener('submit', function(e) {
		  e.preventDefault();
		  level = Number(document.getElementById('levelInput').value);
		  //console.log("level:"+level);
		  max = Math.pow(level, 2) - 1;
		  menu.style.display = "none";
		  startTimer();
		  updateCount();
		  createBoard();
		});

		 document.getElementById("restart1").addEventListener('click',()=>{
				//window.location.reload();
				document.body.removeChild(board);
				menu.style.display = "block";
				completedLevel.style.display = "none";
				gameOver.style.display = "none";
				//completedLevel.style.display = "none";
				stopTimer();
				secondsEl.textContent="00";
				minutesEl.textContent="00";
				document.getElementById('count').textContent="0";
				count=0;
				
			  })

		// for next level
		next.addEventListener('click', function() {
		  completedLevel.style.display = "none";
		  document.getElementById("restart1").style.display="inline-block";
		  level++;
		  max = Math.pow(level, 2) - 1;
		  secondsEl.textContent="00";
		  startTimer();
		  restartCount();
		  createBoard();
		});


		// for creating the board
		function createBoard() {
		  board = document.createElement('div');
		  board.classList.add('board');
		  board.style.height = level * 110 + 'px';
		  board.style.width = level * 110 + 'px';
		  for(i = max; i >= 0; i--) {
			  console.log(i+" ");
			addTile(board);
		  }
		  document.body.appendChild(board);
		};


		// for update count of moves
		function updateCount() {
		  counter.textContent = count++;
		};


		// for restarts count of moves on next level
		function restartCount() {
		  count = 0;
		  updateCount();
		};


		// when tile has been clicked
		function play() {
		  var empty = document.querySelector('.empty');
		  move.call(this, Number(this.textContent), empty);
		  // check if player won
		  if(checkWinCondition()) {
			if(level < 4) {
			  completedLevel.style.display = "block";
			  document.getElementById("restart1").style.display="none";
			  
			} else {
			  gameOver.style.display = "block";
			  document.getElementById("restart1").style.display="none";

			  document.getElementById("gameOverRestart").addEventListener('click',()=>{ 
				menu.style.display = "block";
				secondsEl.textContent="00";
				minutesEl.textContent="00";
				document.getElementById('count').textContent="0";
				count=0;
				gameOver.style.display = "none";
				document.getElementById("restart1").style.display="inline-block";
			  })
			}
			document.body.removeChild(board);
			stopTimer();
		  }
		};
		
			// shuffle
		shuffleButton.addEventListener('click', function() {
		  if(board) {
			for(let i = 0; i < (200 * level); i++) {
			  shuffle();
			}
		  }
		});

		// swapping elements
		function swap(el1, el2) {
		  var tmp = el1.cloneNode(true);
		  el1.parentNode.replaceChild(tmp, el1);
		  el2.parentNode.replaceChild(el1, el2);
		  tmp.parentNode.replaceChild(el2, tmp);
		};


		// creating tile for the board
		function addTile(board) {
		  var tile = document.createElement('div');
			tile.textContent = i;
			//console.log("tile.textContent = "+tile.textContent);
			tile.classList.add('tile');
			tile.addEventListener('click', play);
			board.appendChild(tile);
		 
			if(level % 2 === 0) {
			  if(i === 1) {
				tile.textContent = 2;
				tile.previousSibling.textContent = 1;
			  }
			}
		   
			if(i === 0) {
			  tile.classList.add('empty');
			}
			board.appendChild(tile);
		};

		// checks if tile can be moved to empty space
		function isMovePossible(arr, tile) {
		  
		  for(let i = 0; i < arr.length; i++) {
			if(Number(arr[i].textContent) === tile) {
			  if((arr[i - level] && arr[i - level].textContent == 0) || 
				((arr[i + level]) && arr[i + level].textContent == 0) ||
				((i % level) && arr[i - 1].textContent == 0) || 
				(((i + 1) % level) && arr[i + 1].textContent == 0)
				) {
				return true;
				} 
				else {
				return false;
			  }
			}
		  }
		};

		// moving tiles if possible
		function move(tile, empty) {
		  var arr = Array.from(document.querySelectorAll('.tile'));
		  if(isMovePossible(arr, tile)) {
			swap(this, empty);
			updateCount();
		  } else {
			return false;
		  }
		};

		// shuffling tiles
		function shuffle() {
		  var empty = document.querySelector('.empty');
		  var tiles = Array.from(document.querySelectorAll('.tile'));
		  var emptyPosition = tiles.indexOf(empty);
		  var directions = [tiles[emptyPosition - level], tiles[emptyPosition + level], tiles[emptyPosition + 1], tiles[emptyPosition - 1]].filter(direction => direction);
		  var getRandomDirection = directions[Math.floor(Math.random() * directions.length)];

		  if(isMovePossible(tiles, Number(getRandomDirection.textContent))) {
			swap(empty, getRandomDirection);
		  }
		};

		// checking if all tiles are sorted
		function checkWinCondition() {
		  var arr = Array.from(document.querySelectorAll('.tile'));
		  //console.log(arr);
		  var index = 1;
		  for(let i = 0; i < arr.length; i++) {
			if(i === max) {
			  return true;
			} else {
			  if(Number(arr[i].textContent) !== index) {
				return false;
			  }
			}
			index++;
		  }
		  return true;
		};

		// starting timer
		function startTimer() {
		  var hours = 0;
		  var minutes = 0; 
		  var seconds = 0;

		  // updates timer display
		  function updateTimer(s, m, h) {
			updateElement(secondsEl, s);
			updateElement(minutesEl, m);
			updateElement(hoursEl, h);
		  }
		  // creating timer
		  timer = setInterval(function() {
			
			seconds++;
			
			if(seconds >= 60) {
			  seconds = seconds % 60;
			  minutes++;
			  
			}

			if(minutes >= 60) {
			  minutes = minutes % 60;
			  hours++;
			}

			updateTimer(seconds, minutes, hours);
		  }, 1000);

		};


		// stops the timer
		function stopTimer() {
		  clearTimeout(timer);
		};

		function updateElement(el, value) {
		  el.textContent = value < 10 ? '0' + value : value;
		};

};