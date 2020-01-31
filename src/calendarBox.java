
public class calendarBox {

			int x;
			int y;
			int height;
			int month;
			int day;
			int year;
		public calendarBox(int x, int y, int height, int month, int day, int year) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.month = month;
			this.day = day;
			this.year = year;
		}
		
		public void printBox() {
			System.out.println(month);
		}
		
		public boolean checkClick(int clickx, int clicky) {
			for(int xM = x; xM < (x + height); xM ++) {
				for(int yM = y; yM < (y + height); yM ++) {
					if(clickx == xM) {
						if(clicky == yM) {
							return true;
						}
					}
				}
			}
			
			
			return false;
		}
		
		public int getMonth() {
			return this.month;
		}
		public int getDay() {
			return this.day;
		}
		public int getYear() {
			return this.year;
		}
}
