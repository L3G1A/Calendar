
public class clicableObject {
		int xTop;
		int yTop;
		int height;
		int width;
		String name;
	
	
		public clicableObject(int xTop, int yTop, int height, int width, String name) {
			this.xTop = xTop;
			this.yTop = yTop;
			this.height = height;
			this.width = width;
			this.name = name;
		}
		
		public boolean checkClick(int xClick, int yClick) {
    		System.out.println("Click Prints");



			for(int xCord = xTop; xCord <= (xTop + width); xCord ++) {
				for(int yCord = yTop; yCord < (yTop + height); yCord ++) {
	
	        		
					if(xClick == xCord && yClick == yCord) {
						return true;
					}
				}
			}
			System.out.println("No click Found");
			return false;
		}
		
		
		public String getName() {
			return this.name;
		}
}
