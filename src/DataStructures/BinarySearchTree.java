package DataStructures;


public class BinarySearchTree {
    BinaryTreeNode root = null;

    public void add(int data)
    {
        if(root == null)
        {
            root = new BinaryTreeNode(data);
        }
        else
        {
            BinaryTreeNode current = root;
            while(current != null)
            {
                if(data < current.val)
                {
                    if(current.left == null)
                    {
                        current.left = new BinaryTreeNode(data);
                        break;
                    }
                    else
                    {
                        current = current.left;
                    }
                }

                if(data > current.val)
                {
                    if(current.right == null)
                    {
                        current.right = new BinaryTreeNode(data);
                        break;
                    }
                    else
                    {
                        current = current.right;
                    }
                }

                if(data == current.val)
                {
                    //Already present
                    break;
                }
            }
        }
    }

    public boolean search(int data)
    {
        BinaryTreeNode current = root;

        while(current != null)
        {
            if(current.val == data)
            {
                return true;
            }
            if(current.val > data && current.left != null)
            {
                current = current.left;
            }
            else if(current.val < data && current.right != null)
            {
                current = current.right;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    /*
     * Three different scenarios for delete
     * Deleted Node has no children - Remove reference to node
     * Deleted Node has one child - Replace with one child
     * Deleted Node has two Children - Replace with smallest Node in right or largest in left
     */
    public void delete(int data)
    {
        //Cover scenario root.val == data

        BinaryTreeNode current = root;

        while(current != null)
        {
            if(data < current.val)
            {
                if(current.left == null)
                {
                    break;
                }
                if(data == current.left.val)
                {

                    if(current.left.left == null && current.left.right == null)
                    {
                        current.left = null;
                    }
                    else if(current.left.left != null && current.left.right == null)
                    {
                        current.left = current.left.left;
                    }
                    else if(current.left.left == null && current.left.right != null)
                    {
                        current.left = current.left.right;
                    }
                    else
                    {
                        current.left = DeleteNodeWithTwoChildren(current.left);
                    }
                    break;

                }
                else
                {
                    current = current.left;
                }
            }
            if(data > current.val)
            {
                if(current.right == null)
                {
                    break;
                }
                if(data == current.right.val)
                {
                    if(current.right.left == null && current.right.right == null)
                    {
                        current.right = null;
                    }
                    else if(current.right.left != null && current.right.right == null)
                    {
                        current.right = current.right.left;
                    }
                    else if(current.right.left == null && current.right.right != null)
                    {
                        current.right = current.right.right;
                    }
                    else
                    {
                        current.right = DeleteNodeWithTwoChildren(current.right);
                    }
                    break;
                }
                else
                {
                    current = current.right;
                }
            }
            if(current.val == data)
            {
                current = DeleteNodeWithTwoChildren(current);
                break;
            }
        }
    }

    public BinaryTreeNode DeleteNodeWithTwoChildren(BinaryTreeNode node)
    {
        BinaryTreeNode current = node.left;
        BinaryTreeNode parent = node;
        boolean traversed = false;
        while(current != null)
        {
            if(current.right != null)
            {
                parent = current;
                current = current.right;
                traversed = true;
            }
            else
            {
                if(traversed)
                {
                    node.val = current.val;
                    parent.right = null;
                }
                else
                {
                    node.val = current.val;
                    node.left = null;
                }
                break;

            }
        }
        return node;
    }

    public void preorder(BinaryTreeNode node)
    {
        BinaryTreeNode current = node;
        if(node == null)
        {
            return;
        }
        System.out.print(" " + current.val);
        preorder((node.left));
        preorder(node.right);
    }

    public static void main(String[] args)
    {
        BinarySearchTree bt = new BinarySearchTree();
        bt.add(2);
        bt.add(1);
        bt.add(8);
        bt.add(5);
        bt.add(11);
        bt.add(3);
        bt.add(6);
        bt.preorder(bt.root);
        bt.delete(8);
        System.out.println();
        bt.preorder(bt.root);
        System.out.println();
        System.out.println(" " + bt.search(8));


    }
}
