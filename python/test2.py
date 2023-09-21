import cv2
import numpy as np
import sys


I = cv2.imread(sys.argv[1])


x1, y1 = int(sys.argv[2]),int(sys.argv[3])
x2, y2 = int(sys.argv[4]),int(sys.argv[5])
x3, y3 = int(sys.argv[6]),int(sys.argv[7])
x4, y4 = int(sys.argv[8]),int(sys.argv[9])



# Define the polygon coordinates to use or the crop
polygon = [[[x1,y1],[x2,y2],[x3,y3],[x4,y4]]]

# First find the minX minY maxX and maxY of the polygon
minX = I.shape[1]
maxX = -1
minY = I.shape[0]
maxY = -1
for point in polygon[0]:

    x = point[0]
    y = point[1]

    if x < minX:
        minX = x
    if x > maxX:
        maxX = x
    if y < minY:
        minY = y
    if y > maxY:
        maxY = y

# Go over the points in the image if thay are out side of the emclosing rectangle put zero
# if not check if thay are inside the polygon or not
cropedImage = np.zeros_like(I)
for y in range(0,I.shape[0]):
    for x in range(0, I.shape[1]):

        if x < minX or x > maxX or y < minY or y > maxY:
            continue

        if cv2.pointPolygonTest(np.asarray(polygon),(x,y),False) >= 0:
            cropedImage[y, x, 0] = I[y, x, 0]
            cropedImage[y, x, 1] = I[y, x, 1]
            cropedImage[y, x, 2] = I[y, x, 2]

# Now we can crop again just the envloping rectangle
finalImage = cropedImage[minY:maxY,minX:maxX]

cv2.imwrite('out.png',finalImage)


