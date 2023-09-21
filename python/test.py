import cv2
import numpy as np
import sys

# Read in the image.
im_src = cv2.imread(sys.argv[1])


# Destination image
height, width = int(sys.argv[10]), int(sys.argv[11])
im_dst = np.zeros((height,width,3),dtype=np.uint8)


# Create a list of points size of new image
pts_dst = np.empty((0,2))
pts_dst = np.append(pts_dst, [(0,0)], axis=0)
pts_dst = np.append(pts_dst, [(width-1,0)], axis=0)
pts_dst = np.append(pts_dst, [(width-1,height-1)], axis=0)
pts_dst = np.append(pts_dst, [(0,height-1)], axis=0)


im_temp = im_src


pts_src = np.array([[int(sys.argv[2]),int(sys.argv[3])],
             [int(sys.argv[4]),int(sys.argv[5])],
             [int(sys.argv[6]),int(sys.argv[7])],
             [int(sys.argv[8]),int(sys.argv[9])]])
#cv2.setMouseCallback("Image",mouseHandler)

#print(np.linalg.norm(pts_src[1]-pts_src[0]))
w , h  = (np.linalg.norm(pts_src[1]-pts_src[0]).astype(int),np.linalg.norm(pts_src[3]-pts_src[2]).astype(int))
pts_src = np.array([[int(sys.argv[2]),int(sys.argv[3])],
             [int(sys.argv[4]),int(sys.argv[5])],
             [int(sys.argv[6]),int(sys.argv[7])],
             [int(sys.argv[8]),int(sys.argv[9])]])
tform, status = cv2.findHomography(pts_src, pts_dst)
im_dst = cv2.warpPerspective(im_src, tform,(width,height))
cv2.imwrite("out.png", im_dst)
