class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        class Car{
            int pos;
            int speed;
            double timeToTarget;

            public Car(int pos, int speed){
                this.pos = pos;
                this.speed = speed;
            }
        }

        ArrayList<Car> cars = new ArrayList<>();
        Car dummy;

        for(int i = 0; i < position.length; i++) {
            dummy = new Car(position[i], speed[i]);
            dummy.timeToTarget = (target-position[i])/(speed[i] * 1.0d);
            cars.add(dummy);
        }
        cars.sort((a,b) -> Integer.compare(b.pos, a.pos));

        
        Stack<Double> fleets = new Stack<>();
        for(Car car : cars){

            if(fleets.isEmpty() || car.timeToTarget > fleets.peek()){
                fleets.push(car.timeToTarget);
            }

        }

        return fleets.size();

    }
}
