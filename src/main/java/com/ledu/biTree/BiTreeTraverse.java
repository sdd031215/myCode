package com.ledu.biTree;

/**
 * 给一个单向链表，把它从头到尾反转过来。比如： a -> b -> c ->d 反过来就是 d -> c -> b -> a 。
 *
 */
public class BiTreeTraverse {

	/*
	 * 因为在对链表进行反转的时候，需要更新每一个node的“next”值，但是，在更新 next 的值前，我们需要保存 next 的值，
	 * 否则我们无法继续。所以，我们需要两个指针分别指向前一个节点和后一个节点，每次做完当前节点“next”值更新后，
	 * 把两个节点往下移，直到到达最后节点。
	 */
	public Node reverseBi(Node current) {
		//initialization
		Node previousNode = null;
		Node nextNode = null;
		
		while (current != null) {
			//save the next node
			nextNode = current.next;
			//update the value of "next"
			current.next = previousNode;
			//shift the pointers
			previousNode = current;
			current = nextNode;			
		}
		return previousNode;
	}
	
	/*
	 * 通过递归的方式解决
	 * 递归的方法其实是非常巧的，它利用递归走到链表的末端，然后再更新每一个node的next 值 (代码倒数第二句)。
	 * 在上面的代码中， reverseRest 的值没有改变，为该链表的最后一个node，所以，反转后，我们可以得到新链表的head。
	 */
	public Node reverse(Node current)
	 {
	     if (current == null || current.next == null) return current;
	     Node nextNode = current.next;
	     current.next = null;
	     Node reverseRest = reverse(nextNode);
	     nextNode.next = current;
	     return reverseRest;
	 }

	public static void main(String[] args) {
//		char a = 'a';
//		Node a  = new Node('a');

	}

	
	class Node {
		char value;
		Node next;
		public Node(){}
		public Node(char value){
			this.value = value;
		}
		public char getValue() {
			return value;
		}
		public void setValue(char value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
	}
}


