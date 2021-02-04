# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        nTreeNode = TreeNode(0)
        if not t1:
            return t2
        elif not t2:
            return t1
        
        nTreeNode = TreeNode(t1.val + t2.val)
        nTreeNode.left = self.mergeTrees(t1.left, t2.left)
        nTreeNode.right = self.mergeTrees(t1.right, t2.right)
        return nTreeNode
        
        
