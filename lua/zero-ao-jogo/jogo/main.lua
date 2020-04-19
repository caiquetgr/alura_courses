
LARGURA_TELA, ALTURA_TELA = 320, 480

aviao14_bis = {
    src = "imagens/14bis.png",
    altura = 64,
    largura = 64,
    x = LARGURA_TELA / 2 - (largura / 2),
    y = ALTURA_TELA - (altura * 1.5)
}

function moveAviao()
    if love.keyboard.isDown('w') then
        aviao14_bis.y = aviao14_bis.y - 1
    end
    
    if love.keyboard.isDown('s') then 
        aviao14_bis.y = aviao14_bis.y + 1
    end

    if love.keyboard.isDown('d') then
        aviao14_bis.x = aviao14_bis.x + 1
    end

    if love.keyboard.isDown('a') then
        aviao14_bis.x = aviao14_bis.x - 1
    end
end

-- Load some default values for our rectangle.
function love.load()

    love.window.setMode(LARGURA_TELA, ALTURA_TELA, { resizable = false })
    love.window.setTitle("14Bis vs Meteoros")

    background = love.graphics.newImage("imagens/background.png")
    
    aviao14_bis.imagem = love.graphics.newImage(aviao14_bis.src)

    x, y, w, h = 20, 20, 60, 20
end
 
-- Increase the size of the rectangle every frame.
function love.update(dt)
    
    if love.keyboard.isDown('w', 's', 'a', 'd') then
        moveAviao()
    end

end
 
-- Draw a coloured rectangle.
function love.draw()
    love.graphics.draw(background, 0, 0)
    love.graphics.draw(aviao14_bis.imagem, aviao14_bis.x, aviao14_bis.y)
end