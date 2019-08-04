
public class A3Driver {
	
	public static void main(String[] args) {
		
		A3DoubleLL<Integer> list = new A3DoubleLL<>();
		for(int i = 1; i < 10; i++) {
			list.add(i);
		}
		System.out.println("Before Swap");
		System.out.println(list.printList());
		System.out.println(list.printListRev());
		list.swap(7);
		System.out.println("After Swap");
		System.out.println(list.printList());
		System.out.println(list.printListRev());
		System.out.println();
		
		A3CircleLL hotPotatoe = new A3CircleLL();
		hotPotatoe.playGame(5, 3);
		System.out.println();

		A3Queue<Integer> queue = new A3Queue<>();
		queue.enqueue(5);
		queue.enqueue(20);
		queue.enqueue(15);
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		queue.enqueue(25);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}
}
