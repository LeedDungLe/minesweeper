import java.awt.Font;



public class troChoiDoMin1 {
  // khai báo mấy biến trước đã
    private int d;
       final int n = 10;  // tạo 10x10 ô
         final double p= 0.25;   // xác suất xuất hiện boom tại 1 ô
            private int sobom = 0;  // như cái tên, đây là số boom
         private int min ;
         final boolean a[][] = new boolean[n][n];    // 100 biến a, cái nào có boom thì là true, không có thì là false
         final boolean c[][] = new boolean[n][n];    // cái này y hệt cái a
         final boolean e[][] = new boolean[n][n];     // có cờ là true, không cờ là false
         final boolean f[][] = new boolean[n][n];       // đã mở là true, chưa mở là false

         final int b[][] = new int[n][n];      // 100 biến b có giá trị tương ứng với mấy con số hiện ra trên các ô
         private int dx, dy; // tọa độ chuột thôi
    private int soco = 0;
         
     // Bắt đầu vẽ các ô 
      public void veCacO(){
        StdDraw.setXscale(0, n);        // có n ô theo chiều ngang
          StdDraw.setYscale(0, n+2);    // n ô theo chiều dọc cộng thêm 5 ô ghi thông tin
       for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 StdDraw.setPenColor(StdDraw.BLACK);
                
                StdDraw.square(i + 0.5, j + 0.5, 0.5);    // vẽ ô vuông tại tọa độ (i,j), mỗi cạnh ô vuông dài 0,5 x 2 = 1 đơn vị
            }
        }
      }
         
      
      // tạo các giá trị cho mấy cái mảng a, b, c vừa khai báo ở trên
         public void GanGiaTri() {
             // gán giá trị cho mảng a, true là có boom, false là không có boom, cái này nói rồi
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double keCaiNayDi = Math.random();
                if (keCaiNayDi < p) {  // xác suất có boom ( nghĩa là true ) sẽ xấp xỉ p chứ không hoàn toàn bằng p
                a[i][j] = true;
                sobom ++;   // từ đây ta được số  boom
                }
                else    {
                a[i][j]=false;  // mấy cái không có boom thì a có giá trị false 
                }
            }
        }
         

         Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(1.5 , n+1.25, "Có "+String.valueOf(sobom)+" quả bom"); // ghi thông tin về số boom vào cái phần nãy vừa chừa ra 
         
         // tạo giá trị cho các ô có số, nghĩa là cho mảng b
         for (int j = n-1; j >=0; j--) {
            for (int i = 0; i < n; i++) {
                if (a[i][j])System.out.print("* ");  // in ra console cho dễ chơi và test
                 if (!a[i][j]){
                    d = 0 ;
                    if (i==0){
                        if(j==0){
                           if(a[0][1])d=d+1;
                           if(a[1][0])d=d+1;
                           if(a[1][1])d=d+1;
                        }
                        else if(j==n-1){
                            if(a[0][n-2])d=d+1;
                            if(a[1][n-1])d=d+1;
                            if(a[1][n-2])d=d+1;
                        }
                        else {
                            if(a[1][j])d=d+1;
                            if(a[1][j+1])d=d+1;
                            if(a[1][j-1])d=d+1;
                            if(a[0][j+1])d=d+1;
                            if(a[0][j-1])d=d+1;
                        }
                    }
                    else if(i==n-1){
                        if(j==0){
                           if(a[n-2][1])d=d+1;
                           if(a[n-2][0])d=d+1;
                           if(a[n-1][1])d=d+1;
                        }
                        else if(j==n-1){
                            if(a[n-2][n-2])d=d+1;
                            if(a[n-2][n-1])d=d+1;
                            if(a[n-1][n-2])d=d+1;
                        }
                        else {
                            if(a[n-2][j])d=d+1;
                            if(a[n-2][j+1])d=d+1;
                            if(a[n-2][j-1])d=d+1;
                            if(a[n-1][j+1])d=d+1;
                            if(a[n-1][j-1])d=d+1;
                        }
                    }
                    else{
                        if(j==0){
                           if(a[i][1])d=d+1;
                           if(a[i+1][0])d=d+1;
                           if(a[i+1][1])d=d+1;
                           if(a[i-1][0])d=d+1;
                           if(a[i-1][1])d=d+1;
                        }
                        else if(j==n-1){
                            if(a[i][n-2])d=d+1;
                            if(a[i+1][n-1])d=d+1;
                            if(a[i+1][n-2])d=d+1;
                            if(a[i-1][n-1])d=d+1; 
                            if(a[i-1][n-2])d=d+1; 
                        }
                        else {
                        
                        if(a[i][j+1])d=d+1;
                        if(a[i][j-1])d=d+1;
                        if(a[i+1][j])d=d+1;
                        if(a[i+1][j+1])d=d+1;
                        if(a[i+1][j-1])d=d+1;
                        if(a[i-1][j])d=d+1;
                        if(a[i-1][j-1])d=d+1;
                        if(a[i-1][j+1])d=d+1;
                        }
                    }
                  b[i][j]=d;      System.out.print(d+" "); // mấy cái if else trên là cho mấy trường hợp đặc biệt ( kiểu như trong góc , sát mép thì quanh nó không đủ 8 ô nữa ) thì xét riêng ra
                }
            }
            System.out.println();
        }
            for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            c[i][j] = a[i][j];  // gán mảng c giống y hệt mảng a để sau này dùng 
            e[i][j] = false;
            f[i][j] = false;

            }}
         }
         
         
         
         
         // cái này để hiện ra khi bấm chuột thôi
         public void reveal(int i, int j){
             for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				// nếu bằng 0 hiện ra các ô xung quanh
				if (k >= 0 && k < n && l >= 0 && l < n && c[k][l]==false && b[k][l]==0) {
          Font ww = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(ww);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(k + 0.5, l + 0.5, String.valueOf(b[k][l])); 
        f[k][l]=true;
            c[k][l]=true; // tránh trường hợp bị lặp quay lại chỗ cũ ( nghĩa là  khi vòng lặp mới được hình thành, cái giá trị bằng 0 ở ô vừa xét trước đó sẽ không được tính vào )
            reveal(k,l); // đệ quy, nghĩa là trong mấy ô xung quanh mà lại có ô bằng  không thì lặp lại cái reveal như trước
        
                                }
                                // cái này thì hiện ra cái ô khác 0
                        if (k >= 0 && k < n && l >= 0 && l < n && c[k][l]==false ) {        
                             Font ww = new Font("Arial", Font.BOLD, 30);
                            StdDraw.setFont(ww);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(k + 0.5, l + 0.5, String.valueOf(b[k][l]));   
        c[k][l]=true;
        f[k][l]=true;
                        }
             }
         }
         }
         
         
         
         
         
          // đoạn này bắt đầu tương tác chuột ( khó kinh khủng luôn !!! )
         public  void tuongTacChuot() {
             // sử dụng 2 vòng lặp lồng nhau để nhốt con chuột, một lần nhấp chuột thì vòng lặp đã chạy được tầm 70 chu kì nên phải tạo thêm vòng lặp ngoài để giới hạn con chuột
  while( true){
       
      while (true){
          min = 100; // biếm đếm 
          // tọa độ con chuột
         double x = StdDraw.mouseX();
         double y = StdDraw.mouseY();    
         
         int lx=0 ;
        int ly= 0;
                 
        // khi bấm chuột vào 1 ô, tọa độ chuột nắm trong ô nào thì lệnh tương tác ở ô đó
         for (int i = 0; i<x ;i++){
             lx = i;
         }
         for (int j =0; j<y ;j++){
             ly = j;
         }
        dx = lx;
        dy = ly;
         //bắt đầu bấm chuột
     if (StdDraw.isMousePressed() ) {
       
        if (a[lx][ly]) break; // bấm vô boom thì thua
         else { 
            f[lx][ly] = true;
        if(b[lx][ly]!=0){
            c[lx][ly] = true; // cái ô vừa bấm sẽ chuyển giá trị của c tương ứng từ false sang true, dùng để kết thúc trò chơi khi thắng
            Font ww = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(ww);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(lx + 0.5, ly + 0.5, String.valueOf(b[lx][ly])); 
        }
        
        else{
              Font ww = new Font("Arial", Font.BOLD, 30);
            StdDraw.setFont(ww);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(lx + 0.5, ly + 0.5, String.valueOf(b[lx][ly])); 
        c[lx][ly] = true; // để kết thúc khi thắng thôi
            reveal(lx,ly); // lệnh in ra mấy cái xung quanh mà nãy vừa tạo ra
        }
         }
     }
    if(StdDraw.isKeyPressed(32)){
        if(e[lx][ly]==false ){
        e[lx][ly] = true;
        soco = soco +1;
        StdDraw.picture(lx+0.5, ly+0.5, "flag.PNG");
        }
        else{
            e[lx][ly]=false;
            StdDraw.picture(lx+0.5, ly+0.5, "blank.PNG");
           soco = soco - 1;
        }
        StdDraw.pause(200);
        StdDraw.picture(1.5, n + 0.5, "blank1.PNG");
    Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(1.5 , n+0.25, "Đã cắm "+String.valueOf(soco)+" lá cờ");
    }
     
     // đếm số giá trị true của c, tất cả c đều true thì coi như thắng 
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == true) {
					min--;

				}
			}
		}
                
                if(min == 0 && sobom == soco)break;// đây là điều kiện thắng, ra khỏi vòng lặp
                
  }
      
      if (min == 0 && sobom == soco) break;  // ra khỏi vòng lặp để thắng
     
       if (a[dx][dy]) break; // ra khỏi vòng lặp để thua
       
    }
             
         }
         
   
         
// hiện thị WIN và LOSE
public  void HienThiKetQua() {
       
  if (min!=0){
// in ra tất cả mọi thứ khi mà thua
   StdDraw.clear();
    veCacO();
        Font font = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(1.5 , n+1.25, "Có "+String.valueOf(sobom)+" quả bom"); 
        Font ww = new Font("Arial", Font.BOLD, 70);
        StdDraw.setFont(ww);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(6, n+1, "LOSE");
     
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                 if (a[i][j] ){ 
                 
                     if(!e[i][j])   StdDraw.picture(i+0.5,j+0.5 , "boom.PNG");
                  
                     else StdDraw.picture(i+0.5, j+0.5, "flag.PNG");
                 }
                 
                 else { // xét những ô không có boom
                     if(f[i][j]){ // xét những ô đã được mở 
         Font lol = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(lol);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(i + 0.5, j + 0.5, String.valueOf(b[i][j]));
                     }
                     else { // với các ô chưa được mở
                  if (!e[i][j])
                         StdDraw.picture(i+0.5, j+0.5, "blank.PNG");
                  else StdDraw.picture(i+0.5, j+0.5, "wrongboom.PNG");
                 }
                 }
            }
         }
  }
  
  
  
  
  else {

   Font ww = new Font("Arial", Font.BOLD, 70);
        StdDraw.setFont(ww);
        StdDraw.setPenColor(StdDraw.BLACK);
     StdDraw.text(6, n+1, "WIN");
  }
    
}





// có đủ hết rồi thì nhét hết vào một hàm
         public troChoiDoMin1(){
             veCacO();
             GanGiaTri();
             tuongTacChuot();
             HienThiKetQua();
         } 
         
         
         // bắt đầu chạy
    public static void main(String[] args) {
       
          troChoiDoMin1 a = new troChoiDoMin1();       
         
         
     
    } 
}
