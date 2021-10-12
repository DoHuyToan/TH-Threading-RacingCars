import java.util.Random;

public class Car implements Runnable {
//    Viết một ứng dụng cho phép mô phỏng một cuộc đua xe.
//    Ứng dụng hiển thị một số chiếc xe, với các tốc độ di chuyển ngẫu nhiên.
//    Hiển thị tổng thời gian của từng chiếc xe sau khi hoàn thành cuộc đua.
//        Khởi tạo điểm start(hay km ban đầu)
//        Khởi tạo time bắt đầu cuộc đua
//        Thực hiện vòng lặp Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
//        Khởi tạo vận tốc ngẫu nhiên
//        Tính khoảng cách đã đi được = khoảng cách hiện tại + vận tốc ngẫu nhiên
//        Bắt đầu vẽ quãng đường các xe chạy
    private String name;
    public static int DISTANCE = 100;
    public static int STEP = 2;

    public Car(String name){
        this.name = name;
    }

    @Override
    public void run() {
        // khởi tạo điểm star(hay km ban đầu)
        int runDistance = 0;
        // khởi tạo time bắt đầu cuộc đua
        long startTime = System.currentTimeMillis();  //đánh dấu 1 mốc thời gian tại

        // Kiểm tra chừng nào còn xe chưa kết thúc quãng đường đua thì xe vẫn tiếp tục chạy
        while (runDistance < DISTANCE) {
            try {
                // Tốc độ ngẫu nhiên KM/H, từ 0-20
                int speed = (new Random()).nextInt(20);
                // Tính quãng đường đã đi
                runDistance += speed;
                // Xây dựng đồ họa kết quả
                String log = "|";
                //% quãng đường đi đc
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentTravel >= i + STEP) {
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
