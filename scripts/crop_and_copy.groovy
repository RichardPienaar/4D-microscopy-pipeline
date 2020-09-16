
#@ String imageLoadPath
#@ String imageSavePath
#@ String cropBox

 // cropBox: [[min_x,max_x],[min_y,max_y],[min_z,max_z]], 0 indexed, endpoints included

import ij.IJ
import ij.io.FileSaver
//import java.io.File
import ij.ImagePlus
import ij.ImageStack


int[][] cropBox = Eval.me(cropBox);

ImagePlus im  = IJ.openImage(imageLoadPath);
st = im.getImageStack()
st = st.crop(cropBox[0][0], cropBox[1][0], cropBox[2][0], cropBox[0][1]-cropBox[0][0]+1 , cropBox[1][1]-cropBox[1][0]+1, cropBox[2][1]-cropBox[2][0]+1)    	
im.setStack(st)
new FileSaver( im ).saveAsTiff(imageSavePath);