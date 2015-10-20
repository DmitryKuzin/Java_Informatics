public class Tree {
    Node root;
    public void add(String FIO,String birth) throws FIOExcept{
        if(root==null){
            root=new Node(FIO,birth);
        }else{
            Node n = root;
            while(true) {
                if(n.FIO.equals(FIO)) throw new FIOExcept();
                if (n.FIO.compareTo(FIO)< 0) {
                    if (n.rightSon == null) {
                        n.rightSon = new Node(FIO, birth);
                        break;
                    } else {
                        n = n.rightSon;
                    }
                } else {
                    if(n.leftSon==null) {
                        n.leftSon = new Node(FIO, birth);
                        break;
                    }else{
                        n=n.leftSon;
                    }
                }
            }
        }
    }
    public String get(String FIO) throws FIO404Except {
        return reqursion(FIO,root);
    }
    private String reqursion(String FIO,Node n) throws FIO404Except {
        Node node=n;
        try {
            if (n.FIO.equals(FIO)) {
                return n.birth;
            } else if (n.FIO.compareTo(FIO) < 0) {
                return reqursion(FIO, n.rightSon);
            } else {
                return reqursion(FIO, n.leftSon);
            }
        }catch (NullPointerException e){
            throw new FIO404Except();
        }
    }
    public void remove(String FIO) {
        Node x = root, y = null;
        while (x != null) {
            int cmp = FIO.compareTo(x.FIO);
            if (cmp == 0) {
                break;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.leftSon;
                } else {
                    x = x.rightSon;
                }
            }
        }
        if (x == null) {
            return;
        }
        if (x.rightSon == null) {
            if (y == null) {
                root = x.leftSon;
            } else {
                if (x == y.leftSon) {
                    y.leftSon = x.leftSon;
                } else {
                    y.rightSon = x.leftSon;
                }
            }
        } else {
            Node leftMost = x.rightSon;
            y = null;
            while (leftMost.leftSon != null) {
                y = leftMost;
                leftMost = leftMost.leftSon;
            }
            if (y != null) {
                y.leftSon = leftMost.rightSon;
            } else {
                x.rightSon = leftMost.rightSon;
            }
            x.FIO = leftMost.FIO;
            x.birth = leftMost.birth;
        }
    }

}
