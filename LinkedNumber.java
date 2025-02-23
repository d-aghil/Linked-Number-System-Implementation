public class LinkedNumber {
    private int base; // The base of the number system
    private DLNode<Digit> front; // Reference to the front (most significant digit) of the linked list
    private DLNode<Digit> rear; // Reference to the rear (least significant digit) of the linked list

    // Constructor to create a LinkedNumber from a string representation and given base
    public LinkedNumber(String num, int baseNum) {
        base = baseNum;
        if (num.isEmpty()) {
            throw new LinkedNumberException("no digits given");
        }
        // Create doubly linked list to represent the number
        DLList<Digit> list = new DLList<>();
        for (char c : num.toCharArray()) {
            Digit digit = new Digit(c);
            list.addLast(digit);
        }
        front = list.getFirst();
        rear = list.getLast();
    }

    // Constructor to create a LinkedNumber from an integer (assumed to be in base 10)
    public LinkedNumber(int num) {
        this(String.valueOf(num), 10); // Call the other constructor with base 10
    }

    // Check if the number stored in this LinkedNumber is valid for its base
    public boolean isValidNumber() {
        DLNode<Digit> current = front;
        while (current != null) {
            if (!current.getData().isValid(base)) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    // Get the base of the number system
    public int getBase() {
        return base;
    }

    // Get reference to the front node of the linked list
    public DLNode<Digit> getFront() {
        return front;
    }

    // Get reference to the rear node of the linked list
    public DLNode<Digit> getRear() {
        return rear;
    }

    // Get the number of digits in the linked list
    public int getNumDigits() {
        int count = 0;
        DLNode<Digit> current = front;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Convert the linked list representation to a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLNode<Digit> current = front;
        while (current != null) {
            sb.append(current.getData().getCharValue());
            current = current.getNext();
        }
        return sb.toString();
    }

    // Check if two LinkedNumber objects are equal
    public boolean equals(LinkedNumber other) {
        if (base != other.base) {
            return false;
        }
        DLNode<Digit> current = front;
        DLNode<Digit> otherCurrent = other.front;
        while (current != null && otherCurrent != null) {
            if (!current.getData().equals(otherCurrent.getData())) {
                return false;
            }
            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }
        return current == null && otherCurrent == null; // Check if both lists have been traversed fully
    }

    // Convert the number to a different base
    public LinkedNumber convert(int newBase) {
        if (!isValidNumber()) {
            throw new LinkedNumberException("cannot convert invalid number");
        }
        int decimalValue = convertToDecimal();
        return convertFromDecimal(decimalValue, newBase);
    }

    // Helper method to convert the number to decimal
    private int convertToDecimal() {
        int decimalValue = 0;
        DLNode<Digit> current = front;
        int position = 0;
        while (current != null) {
            int digitValue = current.getData().getDecimalValue();
            decimalValue += digitValue * Math.pow(base, position);
            position++;
            current = current.getNext();
        }
        return decimalValue;
    }

    // Helper method to convert decimal to a different base
    private LinkedNumber convertFromDecimal(int decimalValue, int newBase) {
        StringBuilder convertedNum = new StringBuilder();
        while (decimalValue > 0) {
            int remainder = decimalValue % newBase;
            if (remainder < 10) {
                convertedNum.insert(0, remainder);
            } else {
                convertedNum.insert(0, (char) ('A' + (remainder - 10)));
            }
            decimalValue /= newBase;
        }
        return new LinkedNumber(convertedNum.toString(), newBase);
    }

    // Add a digit at the specified position in the linked list
    public void addDigit(Digit digit, int position) {
        if (position < 0 || position > getNumDigits()) {
            throw new LinkedNumberException("invalid position");
        }
        DLNode<Digit> newNode = new DLNode<>(digit);
        if (position == 0) {
            newNode.setNext(front);
            if (front != null) {
                front.setPrev(newNode);
            }
            front = newNode;
            if (rear == null) {
                rear = newNode;
            }
        } else {
            DLNode<Digit> current = front;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            if (current.getNext() != null) {
                current.getNext().setPrev(newNode);
            }
            current.setNext(newNode);
            if (newNode.getNext() == null) {
                rear = newNode;
            }
        }
    }

    // Remove a digit at the specified position from the linked list
    public int removeDigit(int position) {
        if (position < 0 || position >= getNumDigits()) {
            throw new LinkedNumberException("invalid position");
        }
        int decimalValue = 0;
        DLNode<Digit> current = front;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        decimalValue = current.getData().getDecimalValue();
        if (current == front) {
            front = front.getNext();
            if (front != null) {
                front.setPrev(null);
            }
        } else if (current == rear) {
            rear = rear.getPrev();
            if (rear != null) {
                rear.setNext(null);
            }
        } else {
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
        }
        return decimalValue * (int) Math.pow(base, position);
    }
}
