from random import randrange
import matplotlib.pyplot as plt
import numpy as np
import cv2
import sys

def sift(readimage,readimage2,d):
    #creation sift
   
    sift     = cv2.SIFT_create()
    kp, des = sift.detectAndCompute(readimage, None)
    kp2, des2 = sift.detectAndCompute(readimage2, None)
    #flags pour varier le rayon dec cyrcle depand de l'oriantation et magnitude
    #keypointimage = cv2.drawKeypoints(readimage, kp, None, flags=cv2.DRAW_MATCHES_FLAGS_DRAW_RICH_KEYPOINTS)
    #cv2.imshow('SIFT', keypointimage)
   
    bf = cv2.BFMatcher()
    matches = bf.knnMatch(des,des2, k=2)

    # Apply ratio test
    good = []
    for m,n in matches:
        if m.distance < d*n.distance: #Distance between descriptors
            good.append([m])

    # cv2.drawMatchesKnn expects list of lists as matches.
    
    img3 = cv2.drawMatchesKnn(readimage,kp,readimage2,kp2,good,None,flags=2)

    return len(good) , img3


def resize(img,w,h):
  width = w
  height = h
  dim = (width, height)
    
  # resize image
  resized = cv2.resize(img, dim, interpolation = cv2.INTER_AREA)
  return resized

import glob


seuil = int(sys.argv[3])
pathVehicule = glob.glob("Matricules\\*.png")

allList = []


if float(sys.argv[2]) == 0 :
    for file1 in pathVehicule :  
        readimage = cv2.imread(file1,cv2.IMREAD_GRAYSCALE) 
        readimage2 = cv2.imread('out.png',cv2.IMREAD_GRAYSCALE)
        good , img3 = sift(readimage,readimage2,float(sys.argv[1]))
        
        if good > seuil :
          allList.append([good , img3])

if len(allList) >= 1 and float(sys.argv[2]) == 0:
    find = True
    max = 0
    maxId = -1
    for i in range(len(allList)):
        if(allList[i][0] >= max):
            max = allList[i][0]
            maxId = i

    plt.figure(figsize=(5, 5))
    plt.imshow(allList[maxId][1])
    plt.title("keypoints matches")
    plt.show()

else:
    allList = []
    for file1 in pathVehicule :  
      readimage = cv2.imread(file1,cv2.IMREAD_GRAYSCALE) 
      readimage2 = cv2.imread('out.png',cv2.IMREAD_GRAYSCALE)
      good , img3 = sift(readimage,resize(readimage2,readimage.shape[1],readimage.shape[0]),float(sys.argv[2]))
      if good > seuil :
        allList.append([good , img3])

    if len(allList) >= 1:
        find = True
        max = 0
        maxId = -1
        for i in range(len(allList)):
            if(allList[i][0] >= max):
                max = allList[i][0]
                maxId = i

        plt.figure(figsize=(5, 5))
        plt.imshow(allList[maxId][1])
        plt.title("keypoints matches")
        plt.show()
    else:
        find = False

print(find)