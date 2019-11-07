# import pygame module in this program 
import pygame 
import time

def same_length_tringle(basex, basey,height):
	for h in range(height):


# activate the pygame library . 
# initiate pygame and give permission 
# to use pygame's functionality. 
pygame.init() 

# define the RGB value 
# for white, green, 
# blue, black, red 
# colour respectively. 
white = (255, 255, 255) 
green = (0, 255, 0) 
blue = (0, 0, 128) 
black = (0, 0, 0) 
red = (255, 0, 0) 

# assigning values to X and Y variable 
X = 1000
Y = 800

# create the display surface object 
# of specific dimension..e(X,Y). 
display_surface = pygame.display.set_mode((X, Y)) 

# set the pygame window name 
pygame.display.set_caption('Drawing') 

# completely fill the surface object 
# with white colour 
display_surface.fill(white)  
					
# draw a line using draw.line() 
# method of pygame. 
# pygame.draw.line(surface, color, 
# start point, end point, thickness) 
#pygame.draw.line(display_surface, green, 
#				(5, 5), (300, 5), 2) 


# draw a rectangle using draw.ret() 
# method of pygame. 
# pygame.draw.rect(surface, color, 
# rectangle tuple, thickness) 
# thickness of line parameter is optional. 
pygame.draw.rect(display_surface, blue, 
					(10	, 90, 131, 81))

# draw a circle using draw.circle() 
# method of pygame. 
# pygame.draw.circle(surface, color, 
# center point, radius, thickness) 
pygame.draw.circle(display_surface, 
		green, (76, 130), 41, 5)	
					
pix_arr = pygame.PixelArray(display_surface);
# bx = 10 + 65
# by = 90
# it = 41
# for a in range(it):
#     for b in range(a+1):
#         pix_arr[bx+b][by] = green  
# 	by = by +1
# 	bx = bx -1

# infinite loop 
while True : 
	
	# iterate over the list of Event objects 
	# that was returned by pygame.event.get() method. 

	for event in pygame.event.get() : 

		# if event object type is QUIT 
		# then quitting the pygame 
		# and program both. 
		if event.type == pygame.QUIT : 

			# deactivates the pygame library 
			pygame.quit() 

			# quit the program. 
			quit() 

		# Draws the surface object to the screen. 
		pygame.display.update() 
